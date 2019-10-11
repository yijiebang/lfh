package com.reinfo.ipoly.module.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReportEnginePooledServer implements Runnable {
	protected int serverPort = 4000;
	protected Properties prop = null;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	protected ExecutorService threadPool = Executors.newFixedThreadPool(100);

	public ReportEnginePooledServer(Properties prop) {
		if (prop != null) {
			int port;
			this.serverPort = port = Integer.parseInt(prop.getProperty("serverPort", String.valueOf(this.serverPort)));
			this.prop = prop;
		}
		System.out.println(String.format("Server started at port %s", this.serverPort));
	}

	@Override
	public void run() {
		ReportEnginePooledServer reportEnginePooledServer = this;
		synchronized (reportEnginePooledServer) {
			this.runningThread = Thread.currentThread();
		}
		this.openServerSocket();
		while (!this.isStopped()) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException ex) {
				if (this.isStopped()) {
					System.out.println("Server stopped.");
					break;
				}
				throw new RuntimeException("Error accepting client connection", ex);
			}
			this.threadPool.execute(new ReportGenerator(clientSocket, "Report engine", this.prop));
		}
		this.threadPool.shutdown();
		System.out.println("Server stopped.");
	}

	private synchronized boolean isStopped() {
		return this.isStopped;
	}

	public synchronized void stop() {
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch (IOException ex) {
			throw new RuntimeException("Error closing server", ex);
		}
	}

	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException ex) {
			throw new RuntimeException(String.format("Cannot open port %d", this.serverPort), ex);
		}
	}

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		String propFilePath = "./conf/config.properties";
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(propFilePath);
			if (inputStream != null) {
				prop.load(inputStream);
			}
			ReportEnginePooledServer server = new ReportEnginePooledServer(prop);
			new Thread(server).start();
		} catch (FileNotFoundException ex) {
			throw new FileNotFoundException("property file '" + propFilePath + "' not found");
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
}