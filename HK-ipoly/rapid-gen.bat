cls
@ECHO OFF
@echo 1. ����������Ҫ�����ļ�Ϊgenerator.xml,�����޸����ݿ���������
@echo 2. templateĿ¼Ϊ������������ģ��Ŀ¼,�����ɵ���ģ���Ŀ¼�ṹ
color 0a
TITLE MyBatis�����ļ�������
rd .\out /s/q
mkdir out
@set classpath=%classpath%;.;.\lib\*;.\lib\template-generator.jar
@set PATH=%JAVA_HOME%\bin;%PATH%;
@java -server -Xms10m -Xmx30m com.taopubu.generator.ext.CommandLine -DtemplateRootDir=template
@if errorlevel 1 (
@echo ----------------------------------------------
@echo   ****����***: �����ú�JAVA_HOME�������������л��߼�����classpath·��
@pause
)

:end