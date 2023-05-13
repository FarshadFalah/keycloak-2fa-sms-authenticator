package dasniko.keycloak.authenticator.gateway;

import java.util.Map;

import com.kavenegar.sdk.KavenegarApi;
import com.kavenegar.sdk.excepctions.*;
import com.kavenegar.sdk.models.*;

/**
 * @author Pharshid Imanipour
 */
public class KavehNegarSmsService implements SmsService {

	private static final KavenegarApi  api = new KavenegarApi("4B656662324D4E6379387A764749703836426D3473495952326C75314641646D");

	private final String senderId;

	KavehNegarSmsService(Map<String, String> config) {
		senderId = config.get("senderId");
	}

	@Override
	public void send(String phoneNumber, String message) {
		try {
			SendResult Result = api.send("90008034", phoneNumber, message);
			System.out.print(Result.toString());
	    }
	//    catch (HttpException ex) {
	// 		System.out.print("HttpException  : " + ex.getMessage());
	//    }
	   catch (ApiException ex) {
			System.out.print("ApiException : " + ex.getMessage());
	   }
	}

}
