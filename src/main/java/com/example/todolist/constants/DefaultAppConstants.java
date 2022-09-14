package com.example.todolist.constants;

public class DefaultAppConstants {
    public static final String USERS_PAGE_URL = "/users";
    public static final String USER_DELETE_PAGE_URL = "/users/delete/{id}";
    public static final String USER_SAVE_USER_PAGE_URL ="/saveUser";
    public static final String TODO_SAVE_TODO_PAGE_URL ="/saveTodo";
    public static final String TODO_FIND_ALL_PAGE_URL ="/allTodo";
    public static final String TODO_DELETE_TODO_PAGE_URL ="/deleteTodo";
    public static final String TODO_GET_TODO_PAGE_URL ="/getTodo/{id}";
    public static final String USER_GET_USER_PAGE_URL ="/getUser/{id}";




    /* Group of constants for creating default administrator user in DB, when starting for the first time */
    public static final String DEFAULT_USER_NAME_ADMIN = "admin";
    public static final String DEFAULT_USER_PASSWORD_FOR_ADMIN = "1";
    public static final Long DEFAULT_USER_ADMIN_ID = 1L;
    public static final String DEFAULT_USER_ADMIN_EMAIL = "admin@admin.com";


}
