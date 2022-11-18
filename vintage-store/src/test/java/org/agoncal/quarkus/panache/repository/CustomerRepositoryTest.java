package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindCustomer() {
        // fix docker connection to docker hub first
    }
}
