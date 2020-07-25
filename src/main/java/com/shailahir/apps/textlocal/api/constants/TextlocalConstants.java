package com.shailahir.apps.textlocal.api.constants;

public class TextlocalConstants {

    public enum Errors {
        NO_COMMAND_SPECIFIED(1, "No command specified"),
        UNRECOGNIZED_COMMAND(2, "Unrecognised command."),
        INVALID_LOGIN_DETAILS(3, "Invalid login details."),
        NO_RECIPIENTS(4, "No recipients specified"),
        NO_MESSAGE_CONTENT(5, "No message content"),
        MESSAGE_TOO_LONG(6, "Message too long"),
        INSUFFICIENT_CREDITS(7, "Insufficient credits"),
        INVALID_SCHEDULED_DATE(8, "Invalid schedule date"),
        SCHEDULE_DATE_IN_PAST(9, "Schedule date is in the past"),
        INVALID_GROUP_ID(10, "Invalid group ID"),
        SELECTED_GROUP_EMPTY(11, "Selected group is empty"),
        INVALID_NUMBER_FORMAT(32, "Invalid number format"),
        TOO_MANY_NUMBERS(33, "You have supplied too many numbers"),
        SUPPLIED_BOTH_GROUP_N_NUMBERS(34, "You have supplied both a group ID and a set of numbers"),
        INVALID_SENDER_NAME(43, "Invalid sender name"),
        NO_SENDER_NAME_SPECIFIED(44, "No sender name specified"),
        NO_VALID_NUMBERS_SPECIFIED(51, "No valid numbers specified"),
        SCHEDULE_TIME_NOT_ALLOWED(191, "Schedule time is outside that allowed"),
        CANNOT_SEND_MESSAGE(192, "You cannot send message at this time"),
        INVALID_CONFIG(60, "Textlocal Config is not valid");

        private int errorCode;
        private String errorMessage;

        Errors(int errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public static Errors byCode(int code) {
            for (Errors error : values()) {
                if (error.getErrorCode() == code) {
                    return error;
                }
            }
            return null;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
