package bevans.config.configservice.service;

import bevans.config.configservice.dto.inbound.ConfigRequest;
import bevans.config.configservice.repository.MongoDbRepository;
import bevans.config.configservice.schema.ConfigSchema;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
/*
Service for CRUD operation related to configs.
Will connect to a DB but for now will just return a placeholder
*/

@Service
public class ConfigService {
    @Autowired
    MongoDbRepository mongoDbRepository;

    public Document retrieveConfigById(String configId){
        //ConfigResponse configResponse = new ConfigResponse();
        //configResponse.setConfigName("test");
        //configResponse.setConfigIdentifier("testId");
        //configResponse.setConfigValue("test");
        //configResponse.setLastUpdatedTimestamp(Timestamp.from(Instant.now()));
        //Get Config by id
        //if present, return config
        //if not, return error response TBD

        Document mongoDocument = mongoDbRepository.retrieveConfig(configId);

        return mongoDocument;
    }

    //Add config to database by providing details in request body
    public ConfigSchema addConfigToDB(ConfigRequest request){
        ConfigSchema schema = new ConfigSchema();
        schema.setConfigName(request.getConfigName());
        schema.setConfigId(request.getConfigIdentifier());
        schema.setConfigValue(request.getConfigValue());
        schema.setLastUpdatedTimestamp(Timestamp.from(Instant.now()));
            mongoDbRepository.insertConfig(schema);
        //Set last updated timestamp to now
        return schema;
    }
}
