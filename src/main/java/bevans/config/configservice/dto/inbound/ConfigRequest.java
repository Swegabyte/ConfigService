package bevans.config.configservice.dto.inbound;

public class ConfigRequest {
    String configIdentifier;
    String configName;
    String configValue;

    public String getConfigIdentifier() {
        return configIdentifier;
    }

    public void setConfigIdentifier(String configIdentifier) {
        this.configIdentifier = configIdentifier;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}
