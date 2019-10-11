cls
@ECHO OFF
@echo 1. 生成器的主要配置文件为generator.xml,里面修改数据库连接属性
@echo 2. template目录为代码生成器的模板目录,可自由调整模板的目录结构
color 0a
TITLE MyBatis配置文件生成器
rd .\out /s/q
mkdir out
@set classpath=%classpath%;.;.\lib\*;.\lib\template-generator.jar
@set PATH=%JAVA_HOME%\bin;%PATH%;
@java -server -Xms10m -Xmx30m com.taopubu.generator.ext.CommandLine -DtemplateRootDir=template
@if errorlevel 1 (
@echo ----------------------------------------------
@echo   ****错误***: 请设置好JAVA_HOME环境变量再运行或者检查你的classpath路径
@pause
)

:end