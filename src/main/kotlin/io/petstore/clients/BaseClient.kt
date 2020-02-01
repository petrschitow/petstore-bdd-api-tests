package io.petstore.clients

import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import io.swagger.petstore.constants.Endpoints.PETSTORE_URL

open class BaseClient {

    val requestSpecification: RequestSpecification =
            RequestSpecBuilder()
                    .setBaseUri(PETSTORE_URL)
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter(LogDetail.URI))
                    .addFilter(RequestLoggingFilter(LogDetail.BODY))
                    .addFilter(ResponseLoggingFilter(LogDetail.BODY))
                    .build()
}