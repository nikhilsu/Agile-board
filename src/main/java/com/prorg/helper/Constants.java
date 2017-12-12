package com.prorg.helper;

public class Constants {
    public static class SessionKeys {
        public static final String LOGGED_IN_USER = "loggedInUser";
    }

    public static class ModelAttributes {
        public static final String MESSAGE = "message";
        public static final String USERS = "users";
    }

    public static class Route {
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String REGISTER = "/register";
        public static final String ROOT = "/";
        public static final String ADD_STORYBOARD = "/addStoryboard";
        public static final String ADD_SWIMLANE = "/addSwimlane";
        public static final String ADD_CARD = "/addCard";
        public static final String UPDATE_USERS_OF_CARD = "/card/{id}/users";
        public static final String UPDATE_USERS_OF_STORYBOARD = "/storyboard/{id}/users";
    }

    public static class RedirectPage {
        public static final String INDEX = "index";
        public static final String STORY_BOARD_FORM = "addStoryboardForm";
        public static final String LOGIN_FORM = "login";
        public static final String REGISTRATION_FORM = "registrationForm";
    }
}
