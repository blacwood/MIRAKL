package com.bigname.core.restful.client.error;

/**
 * Created by Manu on 1/30/2017.
 */
public class ErrorResponse {
        private int status;
        private String message;

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ErrorResponse that = (ErrorResponse) o;

            if (status != that.status) {
                return false;
            }
            return message != null ? message.equals(that.message) : that.message == null;

        }

        @Override
        public int hashCode() {
            int result = status;
            result = 31 * result + (message != null ? message.hashCode() : 0);
            return result;
        }
}
