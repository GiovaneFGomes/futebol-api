package com.giovane.futebol.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundDetails {

    private String title;
    private Integer status;
    private String details;
    private Instant timestamp;
    private String developerMessage;

    public static final class NotFoundDetailsBuilder {
        private String title;
        private int status;
        private String details;
        private Instant timestamp;
        private String developerMessage;

        public static NotFoundDetailsBuilder newBuilder() {
            return new NotFoundDetailsBuilder();
        }

        public NotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public NotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public NotFoundDetailsBuilder details(String detail) {
            this.details = detail;
            return this;
        }

        public NotFoundDetailsBuilder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public NotFoundDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public NotFoundDetails build() {
            NotFoundDetails notFoundDetails = new NotFoundDetails();
            notFoundDetails.timestamp = this.timestamp;
            notFoundDetails.details = this.details;
            notFoundDetails.title = this.title;
            notFoundDetails.developerMessage = this.developerMessage;
            notFoundDetails.status = this.status;
            return notFoundDetails;
        }
    }

}
