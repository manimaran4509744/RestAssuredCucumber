Feature:ToCheckCrudOperationOnRestTravellersApi
Scenario:ToValidateTheStatusCodeOfGetRequest
Given The base uri is "http://restapi.adequateshop.com"
When the get request is sent to an endpoint
|Endpoint|
|/api/Tourist|
Then the status code should be "200"
And  the status message should be "HTTP/1.1 200 OK"
Scenario:ToValidateTheStatusCodeOfPostRequest
Given The base uri is "http://restapi.adequateshop.com"
And the base path is set
|/api/Tourist|
And   the content type is provided
And body is provided
|tourist_name|tourist_email|tourist_location|createdat|
|Vanitharajan|Vanitharajan1234@yahoo.com|Broadway|2023-02-21T15:03:51.3438024Z|
When the post request is sent to an endpoint
Then the status code should be in "201"
And the status message should be in "HTTP/1.1 201 Created"
Scenario:ToValidateTheStatusCodeOfUploadRequest
Given The base uri is "http://restapi.adequateshop.com"
And the base path is set
|/api/Tourist|
And   the content type is provided
And update body is provided
|tourist_name|tourist_email|tourist_location|createdat|
|Rusitha|Rusitha234@yahoo.com|Broadway|2023-02-21T15:03:51.3438024Z|
When the put request is sent to an endpoint
Then the status code should be in the "200"
And the status message should be in the "HTTP/1.1 200 OK"

  