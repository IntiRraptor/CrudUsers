package users.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class CrudUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUsersApplication.class, args);

		// Replace the placeholder with your MongoDB deployment's connection string
		String uri = "mongodb+srv://dbInti:IntiRraptor@intirraptor.3hez9kx.mongodb.net/?retryWrites=true&w=majority&appName=IntiRraptor";
		
		try (MongoClient mongoClient = MongoClients.create(uri)) {
			MongoDatabase database = mongoClient.getDatabase("sample_mflix");
			MongoCollection<Document> collection = database.getCollection("movies");
			Document doc = collection.find(eq("title", "Back to the Future")).first();
			if (doc != null) {
//                System.out.println(doc.toJson());
			} else {
				System.out.println("No matching documents found.");
			}
		}
	}

}
