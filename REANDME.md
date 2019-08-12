# 启动
## window下
1. 命令行模式进入该项目，执行   
`
mvn clean package -Ptest
`
-P后面可以指定环境，该项目可以指定-Pdev和-Ptest   

## linux下启动   
直接在命令行输入    
```
./build.sh test
```
test可以改变为dev