package com.order_app.inventory_service.exception;

public class AbstractException extends RuntimeException {

        public AbstractException(String message) {
            super(message);
        }

        public AbstractException(String message, Throwable cause) {
            super(message, cause);
        }

        public AbstractException(Throwable cause) {
            super(cause);
        }

}
