package service;

import model.Account;

/**
 * Interface representing features available after successful login.
 */
public interface loginFeatures {

    /**
     * Provides post-login features for the given account.
     *
     * @param account the logged-in account
     */
    void loginFeatures(Account account);
}
