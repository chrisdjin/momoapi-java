package ug.sparkpl.momoapi;

import java.io.IOException;
import java.util.HashMap;

import ug.sparkpl.momoapi.network.MomoApiException;
import ug.sparkpl.momoapi.network.RequestOptions;
import ug.sparkpl.momoapi.network.collections.CollectionsClient;

import org.apache.commons.cli.ParseException;


public class MomoApi {


  MomoApi() {


  }

  /**
   * Provision Sandbox Account.
   *
   * @param args providerCallBackHost and primaryKey(Ocp-Apim-Subscription-Key)
   * @throws ParseException when args are missing
   * @throws IOException    when network error occurs
   */
  public static void main(String[] args) throws ParseException, IOException {


    // Make a request to pay call
    RequestOptions opts = RequestOptions.builder()
        .build();

    HashMap<String, String> collMap = new HashMap<String, String>();
    collMap.put("amount", "100");
    collMap.put("mobile", "0782123456");
    collMap.put("externalId", "ext123");
    collMap.put("payeeNote", "testNote");
    collMap.put("payerMessage", "testMessage");

    CollectionsClient client = new CollectionsClient(opts);

    try {
      String transactionRef = client.requestToPay(collMap);
      System.out.println(transactionRef);
    } catch (MomoApiException e) {
      e.printStackTrace();
    }


  }

}
