package my.company.steps;

class Locators {
    static String PAYMENTS_LOCATOR = "//span[text()=\"Платежи\"]";

    static String FIELD_PAYER_CODE_LOCATOR = "//input[@name='fieldpayerCode']";
    static String LOOKUP_RESULTS_LOCATOR = "//div[@class=\"ui-search-flat__title-box\"]";
    static String COMMUN_PAYMENTS_LOCATOR = "//span[text()=\"Коммунальные платежи\"]";
    static String LOOKUP_INPUT_LOCATOR = "//input[@class=\"ui-search-input__input\"]";

    static String COMMUN_GRID_LOCATOR = "//li[@class=\"ui-menu__item ui-menu__item_icons\"]";
    static String LOCATION_LOCATOR = "//span[@class=\"ui-link payment-page__title_inner\"]";

    static String PERIOD_LOCATOR = "//input[@name='fieldperiod']";
    static String PAYERCODE_LOCATOR = "//input[@name='fieldpayerCode']";
    static String ERROR_MSG_LOCATOR = "//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']";

}
