package ug.sparkpl.momoapi.network.remittances;

import ug.sparkpl.momoapi.models.AccessToken;
import ug.sparkpl.momoapi.models.Balance;
import ug.sparkpl.momoapi.models.Transaction;
import ug.sparkpl.momoapi.models.Transfer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RemittancesApiService {

  /**
   * @param body
   * @param ref
   * @return
   */
  @POST("/remittance/v1_0/transfer/")
  @Headers("Content-Type: application/json")
  Call<Void> transfer(@Body Transfer body, @Header("X-Reference-Id") String ref);

  /**
   * @param credentials
   * @param subscriptionKey
   * @return
   */
  @POST("/remittance/token/")
  @Headers("Content-Type: application/json")
  Call<AccessToken> getToken(@Header("Authorization") String credentials, @Header("Ocp-Apim-Subscription-Key") String subscriptionKey);

  /**
   * Get Account Balance
   */
  @Headers("Content-Type: application/json")
  @GET("/remittance/v1_0/account/balance")
  Call<Balance> getBalance();

  /**
   * @param transaction_id
   * @return
   */
  @GET("/remittance/v1_0/transfer/{transaction_id}")
  @Headers("Content-Type: application/json")
  Call<Transaction> getTransactionStatus(@Path("transaction_id") String transaction_id);

}
