package bevans.config.configservice.schema;

import java.sql.Timestamp;

public class ConfigSchema {
    String _id;
    String configName;
    String configValue;
    Timestamp lastUpdatedTimestamp;

    public String getConfigId() {
        return _id;
    }

    public void setConfigId(String configIdentifier) {
        this._id = _id;
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

    public Timestamp getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }
}
