jar -cmf com/lybj/base/jvm/META-INF/MANIFEST.MF agent.jar com/lybj/base/jvm/*(MANIFEST.MF 注意回车与空格，这个文件的内容排版必须标准)
java -javaagent:agent.jar -cp . com.lybj.base.jvm.MyAgent

#注意点
#1. jar的打包路劲
#2. -cp . 是把当前路劲加入到CLASSPATH
#3. java命令执行打包时，要跳到跟路劲，比如com.lybj.base.jvm要跳到com所在路劲
#