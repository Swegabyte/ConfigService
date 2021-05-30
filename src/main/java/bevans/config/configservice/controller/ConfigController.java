package bevans.config.configservice.controller;

import bevans.config.configservice.dto.inbound.ConfigRequest;
import bevans.config.configservice.schema.ConfigSchema;
import bevans.config.configservice.service.ConfigService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config/")
public class ConfigController {
    @Autowired
    ConfigService configService;

    //TODO: Instead of returning document, return ConfigResponse Json
    @GetMapping(value = "/retrieve/{configId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  Document getConfigById(@PathVariable String configId){
        Document response = configService.retrieveConfigById(configId);
        return response;
    }

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ConfigSchema getConfigById(@RequestBody ConfigRequest configRequest){
        ConfigSchema response = configService.addConfigToDB(configRequest);
        return response;
    }

}
