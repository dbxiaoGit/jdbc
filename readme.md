* DROP TABLE t_user IF EXISTS 在mysql中写法为  DROP TABLE IF EXISTS t_user
* mysql建表指定字符编码 DEFAULT CHARSET=utf8 切记不要写成utf-8
* eclipse创建的gradle项目在ide里运行的时候build里面的class不在classpath里面，一运行就报找不到类，需要手动添加到classpath，不知道是咋回事
* mysql密码为空时用yml配置的数据库druid无法正常初始化，搞了半天不知道咋回事，报错信息有限不好排查，可能还是classpath的问题导致配置文件不在classpath里面吧，代码里set各属性之后就正常了。。。
* gradle同步慢，在gradle/gradle-wrapper.properties中修改distributionUrl=http\://localhost/gradle/gradle-4.7-bin.zip（自行准备一个吧）
* 本项目spring-boot-starter-test、spring-boot-starter-thymeleaf、logback.xml、application.yml都没有用上