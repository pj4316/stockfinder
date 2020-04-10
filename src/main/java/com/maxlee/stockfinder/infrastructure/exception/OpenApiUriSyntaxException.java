package com.maxlee.stockfinder.infrastructure.exception;

public class OpenApiUriSyntaxException extends RuntimeException {

  public OpenApiUriSyntaxException(Throwable t) {
    super("OpenApiUriSyntaxException : 잘못된 uri 입니다.", t);
  }
}
