package org.stepDefinitionFiles;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CrudOperation {
	private Response get;
	private Response post;
	private Response put;
	private RequestSpecification requestSpecification;
	private int id;

	@Given("The base uri is {string}")
	public void the_base_uri_is(String baseUri) {
		RestAssured.baseURI = baseUri;
	}

	@When("the get request is sent to an endpoint")
	public void the_get_request_is_sent_to_an_endpoint(DataTable dataTable) {
		List<Map<String, String>> map2 = dataTable.asMaps(String.class, String.class);
		Map<String, String> map = map2.get(0);
		String endPoint = map.get("Endpoint");
		get = given().get(endPoint);
	}

	@Then("the status code should be {string}")
	public void the_status_code_should_be(String expectedStatusCode) {
		int actualStatusCode = get.getStatusCode();
		Assert.assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
	}

	@Then("the status message should be {string}")
	public void the_status_message_should_be(String expectedStatusMessage) {
		String actualStatusMessage = get.getStatusLine();
		Assert.assertEquals(actualStatusMessage, expectedStatusMessage);

	}

	@Given("the base path is set")
	public void the_base_path_is_set(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);
		List<String> list2 = list.get(0);
		String basePath = list2.get(0);
		RestAssured.basePath = basePath;
	}

	@Given("the content type is provided")
	public void the_content_type_is_provided() {
		requestSpecification = given().contentType(ContentType.JSON);
	}

	@Given("body is provided")
	public void body_is_provided(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
		Map<String, String> map = maps.get(0);
		requestSpecification.body(map);
	}

	@When("the post request is sent to an endpoint")
	public void the_post_request_is_sent_to_an_endpoint() {
		
		post = requestSpecification.post();
	}

	@Then("the status code should be in {string}")
	public void the_status_code_should_be_in(String expectedStatusCode) {
		int actualStatusCode = post.getStatusCode();
		System.out.println(post.asPrettyString());
		Assert.assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
		id = post.jsonPath().getInt("id");

	}

	@Then("the status message should be in {string}")
	public void the_status_message_should_be_in(String expectedStatusMessage) {
		String actualStatusMessage = post.getStatusLine();
		Assert.assertEquals(actualStatusMessage, expectedStatusMessage);
	}

	@Given("update body is provided")
	public void update_body_is_provided(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
		Map<String, String> map = maps.get(0);
		requestSpecification.body(map);
		
	}




	@When("the put request is sent to an endpoint")
	public void the_put_request_is_sent_to_an_endpoint() {
		 put = requestSpecification.put("/"+id);
		 
		
	}
	@Then("the status code should be in the {string}")
	public void the_status_code_should_be_in_the(String expectedStatusCode) {
		int actualStatusCode = put.getStatusCode();
		System.out.println(put.asPrettyString());
		Assert.assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
		
	}
	@Then("the status message should be in the {string}")
	public void the_status_message_should_be_in_the(String expectedStatusMessage) {
		String actualStatusMessage = put.getStatusLine();
		Assert.assertEquals(actualStatusMessage, expectedStatusMessage);
	}



}
