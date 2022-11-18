package org.agoncal.quarkus.panache;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindPublisher() {
        // fix docker connection to docker hub first
    }
}
