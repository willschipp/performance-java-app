package com.example.performance.gatling;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class SimpleLoadSimulation extends Simulation {

  String host = System.getProperty("host", "http://localhost:8080");
  String url = System.getProperty("url", "/persons");
  Integer rampUserCount = Integer.getInteger("rampUser", 10);
  Integer rampDuring = Integer.getInteger("rampDuring", 10);

  HttpProtocolBuilder httpProtocol = http.baseUrl(host)
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .doNotTrackHeader("1")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0");

      
  ScenarioBuilder scn = scenario("Persons")
      .exec(http("request_1")
        .get(url))
      .pause(5);

  {
    setUp(
        scn.injectOpen(rampUsers(rampUserCount).during(rampDuring))).protocols(httpProtocol);
  }

}
