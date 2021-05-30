package bevans.config.configservice.repository;

import bevans.config.configservice.schema.ConfigSchema;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;

import static com.mongodb.client.model.Filters.*;

@Repository
public class MongoDbRepository {

    @Value( "${mongodb.hostname}" )
    private String dbHostname;
    @Value( "${mongodb.port}" )
    private String dbPort;
    @Value( "${mongodb.dbname}" )
    private String databaseName;
    @Value( "${mongodb.dbcollection}" )
    private String dbcollection;

    MongoClient mongoClient = new MongoClient();
    MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
    MongoCollection<Document> collection = mongoDatabase.getCollection(dbcollection);

    public Document retrieveConfig(String id){
        Document document = collection.find(eq("_id", id)).first();
        return document;
    }

    public void insertConfig(ConfigSchema configSchema){

        Document document = new Document("_id", configSchema.getConfigId())
                .append("configName", configSchema.getConfigName())
                .append("configValue", configSchema.getConfigValue())
                .append("lastUpdatedTimestamp", Timestamp.from(Instant.now()));
        collection.insertOne(new Document(document));

    }

}
