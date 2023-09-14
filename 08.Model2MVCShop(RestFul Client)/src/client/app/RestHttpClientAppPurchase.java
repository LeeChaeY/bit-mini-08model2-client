package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;



public class RestHttpClientAppPurchase {

	// main Method
	public static void main(String[] args) throws Exception{

		////////////////////////////////////////////////////////////////////////////////////////////
		// 주석을 하나씩 처리해가며 실습
		////////////////////////////////////////////////////////////////////////////////////////////

//		RestHttpClientAppPurchase.getPurchaseTest_JsonSimple();

//		RestHttpClientAppPurchase.getPurchaseTest_Codehaus();
		
//		RestHttpClientAppPurchase.addPurchaseGetTest_JsonSimple();
		
//		RestHttpClientAppPurchase.addPurchaseGetTest_Codehaus();
		
//		RestHttpClientAppPurchase.addPurchasePostTest_JsonSimple();
		
//		RestHttpClientAppPurchase.addPurchasePostTest_Codehaus();
		
//		RestHttpClientAppPurchase.updatePurchaseGetTest_JsonSimple();
		
//		RestHttpClientAppPurchase.updatePurchaseGetTest_Codehaus();
		
//		RestHttpClientAppPurchase.updatePurchasePostTest_JsonSimple();
		
//		RestHttpClientAppPurchase.updatePurchasePostTest_Codehaus();
		
//		RestHttpClientAppPurchase.listPurchaseGetTest_JsonSimple();
		
//		RestHttpClientAppPurchase.listPurchaseGetTest_Codehaus();
		
//		RestHttpClientAppPurchase.listPurchasePostTest_JsonSimple();
		
//		RestHttpClientAppPurchase.listPurchasePostTest_Codehaus();
		
//		RestHttpClientAppPurchase.updateTranCodeByProdGetTest_JsonSimple();
		
//		RestHttpClientAppPurchase.updateTranCodeByProdGetTest_Codehaus();
		
		RestHttpClientAppPurchase.updateTranCodeGetTest_JsonSimple();
		
//		RestHttpClientAppPurchase.updateTranCodeGetTest_Codehaus();

	}


	//================================================================//
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
	public static void getPurchaseTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/getPurchase/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}


	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib 사용
	public static void getPurchaseTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/getPurchase/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		System.out.println(purchase);
	}
	//================================================================//	

	public static void addPurchaseGetTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/addPurchase/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
	}
	
	public static void addPurchaseGetTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/addPurchase/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		System.out.println(purchase);
	}


	public static void addPurchasePostTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/08Model2/purchase/json/addPurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		User user =  new User("cccc", "cccc", "cccc", "9903082222222", "010-1111-2222", "cccc", "chland23@naver.com");
		
		Product product =  new Product();
		product.setProdNo(10007);
		product.setProdName("삼성센스");
		product.setProdDetail("노트북");
		product.setManuDate("20120212");
		product.setPrice(600000);
		product.setFileName("AHlbAAAAug1vsgAA.jpg");
		
		Purchase purchase01 = new Purchase();
		purchase01.setBuyer(user);
		purchase01.setPurchaseProd(product);
		purchase01.setPaymentOption("0");
		purchase01.setReceiverName("testReceiverName");
		purchase01.setReceiverPhone("010-1111-2222");
		purchase01.setDivyAddr("testDivyAddr");
		purchase01.setDivyRequest("testDivyRequest");
		purchase01.setDivyDate("2023-09-15");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(purchase01);

		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");

		httpPost.setEntity(httpEntity01);
		
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);

	}


	//2.2 Http Protocol POST 방식 Request : FromData전달 
	//==> JsonSimple + codehaus 3rd party lib 사용
	public static void addPurchasePostTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/08Model2/purchase/json/addPurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

User user =  new User("cccc", "cccc", "cccc", "9903082222222", "010-1111-2222", "cccc", "chland23@naver.com");
		
		Product product =  new Product();
		product.setProdNo(10004);
		product.setProdName("인라인");
		product.setProdDetail("좋아욥");
		product.setManuDate("20120819");
		product.setPrice(20000);
		product.setFileName("AHlbAAAAve37LwAD.jpg");
		
		Purchase purchase01 = new Purchase();
		purchase01.setBuyer(user);
		purchase01.setPurchaseProd(product);
		purchase01.setPaymentOption("0");
		purchase01.setReceiverName("testReceiverName");
		purchase01.setReceiverPhone("010-1111-2222");
		purchase01.setDivyAddr("testDivyAddr");
		purchase01.setDivyRequest("testDivyRequest");
		purchase01.setDivyDate("2023-09-15");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(purchase01);

		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");

		httpPost.setEntity(httpEntity01);
		
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		System.out.println(purchase);

	}	
	
	public static void updatePurchaseGetTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/updatePurchase"
				+"/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);
	}
	
	public static void updatePurchaseGetTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/updatePurchase"
				+"/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Purchase purchase = objectMapper.readValue(jsonobj.toString(), Purchase.class);
		System.out.println(purchase);

	}	

	public static void updatePurchasePostTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/08Model2/purchase/json/updatePurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Purchase purchase01 =  new Purchase();
		purchase01.setTranNo(10000);
		purchase01.setPaymentOption("0");
		purchase01.setReceiverName("testReceiverName");
		purchase01.setReceiverPhone("010-1111-2222");
		purchase01.setDivyAddr("testDivyAddr");
		purchase01.setDivyRequest("testDivyRequest");
		purchase01.setDivyDate("2023-07-07");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(purchase01);

		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");

		httpPost.setEntity(httpEntity01);
		
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);

	}


	//2.2 Http Protocol POST 방식 Request : FromData전달 
	//==> JsonSimple + codehaus 3rd party lib 사용
	public static void updatePurchasePostTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/08Model2/purchase/json/updatePurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		Purchase purchase01 =  new Purchase();
		purchase01.setTranNo(10000);
		purchase01.setPaymentOption("1");
		purchase01.setReceiverName("changeReceiverName");
		purchase01.setReceiverPhone("010-1111-2222");
		purchase01.setDivyAddr("changeDivyAddr");
		purchase01.setDivyRequest("changeDivyRequest");
		purchase01.setDivyDate("2023-07-07");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(purchase01);

		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");

		httpPost.setEntity(httpEntity01);
		
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(jsonobj.toString(), Map.class);
		System.out.println(map);

	}	
	
	public static void listPurchaseGetTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/listPurchase";
//		+"?currentPage=2";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
	}
	
	public static void listPurchaseGetTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/listPurchase";
//		+"?currentPage=2";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(jsonobj.toString(), Map.class);
		System.out.println(map);

	}	

	public static void listPurchasePostTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/08Model2/purchase/json/listPurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		ObjectMapper objectMapper01 = new ObjectMapper();
		
		Map map01 = new HashMap();
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		
		map01.put("search", search);
		map01.put("userId", "cccc");
		map01.put("beginDate", "");
		map01.put("endDate", "");
		
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(map01);

		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");

		httpPost.setEntity(httpEntity01);
		
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);

		//==> 내용읽기(JSON Value 확인)
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println(jsonobj);

	}


	//2.2 Http Protocol POST 방식 Request : FromData전달 
	//==> JsonSimple + codehaus 3rd party lib 사용
	public static void listPurchasePostTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url = "http://127.0.0.1:8080/08Model2/purchase/json/listPurchase";
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		ObjectMapper objectMapper01 = new ObjectMapper();
		
		Map map01 = new HashMap();
		
		Search search = new Search();
		search.setCurrentPage(1);
		
		map01.put("search", search);
		map01.put("userId", "cccc");
		map01.put("beginDate", "");
		map01.put("endDate", "");
		
		//Object ==> JSON Value 로 변환
		String jsonValue = objectMapper01.writeValueAsString(map01);
		
		System.out.println(jsonValue);

		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");

		httpPost.setEntity(httpEntity01);
		
		HttpResponse httpResponse = httpClient.execute(httpPost);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);

		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(jsonobj.toString(), Map.class);
		System.out.println(map);

	}	
	
	public static void updateTranCodeByProdGetTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/updateTranCodeByProd"
		+"?currentPage=1&prodNo=10002&tranCode=2";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
	}
	
	public static void updateTranCodeByProdGetTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/updateTranCodeByProd"
		+"?currentPage=1&prodNo=10007&tranCode=2";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(jsonobj.toString(), Map.class);
		System.out.println(map);
	}
	
	public static void updateTranCodeGetTest_JsonSimple() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/updateTranCode"
		+"?currentPage=1&tranNo=10000&tranCode=3";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println(serverData);
	}
	
	public static void updateTranCodeGetTest_Codehaus() throws Exception{

		// HttpClient : Http Protocol 의 client 추상화 
		HttpClient httpClient = new DefaultHttpClient();

		String url= 	"http://127.0.0.1:8080/08Model2/purchase/json/updateTranCode"
		+"?currentPage=1&tranNo=10020&tranCode=3";

		// HttpGet : Http Protocol 의 GET 방식 Request
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화
		HttpResponse httpResponse = httpClient.execute(httpGet);

		//==> Response 확인
		System.out.println(httpResponse);
		System.out.println();

		//==> Response 중 entity(DATA) 확인
		HttpEntity httpEntity = httpResponse.getEntity();

		//==> InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println(jsonobj);

		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(jsonobj.toString(), Map.class);
		System.out.println(map);
	}

}