package cn.x;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcTemp implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String args[]) {
        SpringApplication.run(JdbcTemp.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@Override
	public void run(String... args) throws Exception {
		logger.info("run...");
		jdbcTemplate.execute("DROP TABLE IF EXISTS t_user");
        jdbcTemplate.execute("CREATE TABLE `t_user` (`id` int(11) NOT NULL auto_increment,`name` varchar(20) DEFAULT NULL,`age` int(11) DEFAULT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8");

        List<Object[]> splitUpUsers = Arrays.asList("张三 18", "李四 22", "王五 33", "赵六 44").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        splitUpUsers.forEach(user -> logger.info(String.format("Inserting t_user record for %s %s", user[0], user[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO t_user(name, age) VALUES (?,?)", splitUpUsers);

        logger.info("Querying for t_user records :");
        jdbcTemplate.query(
                "SELECT id,name , age FROM t_user limit ? ", new Object[] { 10},
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"))
        ).forEach(user -> logger.info(user.toString()));
	}
}
