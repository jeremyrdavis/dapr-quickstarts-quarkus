package io.arrogantprogrammer;

public class DaprSubscription {

    private String pubSubName;
    private String topic;
    private String route;

    public DaprSubscription(String pubSubName, String topic, String route) {
        this.pubSubName = pubSubName;
        this.topic = topic;
        this.route = route;
    }

    @Override
    public String toString() {
        return "DaprSubscription{" +
                "pubSubName='" + pubSubName + '\'' +
                ", topic='" + topic + '\'' +
                ", route='" + route + '\'' +
                '}';
    }

    public DaprSubscription() {
    }

    public String getPubSubName() {
        return pubSubName;
    }

    public String getTopic() {
        return topic;
    }

    public String getRoute() {
        return route;
    }
}
