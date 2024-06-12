package com.example.MicroEmployeeMaintenance;

import com.sun.tools.javac.Main;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  MicroEmployeeMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroEmployeeMaintenanceApplication.class, args);

		System.setProperty("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");
		Log log = LogFactory.getLog(Main.class);

		log.info("You do not want to see me");
	}

}
