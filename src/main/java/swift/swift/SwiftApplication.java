		package swift.swift;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.beans.factory.annotation.Autowired;
		import jakarta.annotation.PostConstruct;
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.SQLException;
		import swift.swift.service.*;
		@SpringBootApplication
		public class SwiftApplication {
			@Autowired
			private SwiftDataParserService swiftDataParserService;

			public static void main(String[] args) {
				SpringApplication.run(SwiftApplication.class, args);
			}

			@PostConstruct
			public void init() {
				swiftDataParserService.loadSwiftData(); 
			}

		}


