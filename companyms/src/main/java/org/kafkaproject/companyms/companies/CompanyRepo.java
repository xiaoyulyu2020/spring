package org.kafkaproject.companyms.companies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
