package com.qrclub.repository;

import com.qrclub.model.QRCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QrCodeRepository extends JpaRepository<QRCodeEntity, Long> {
    Optional<QRCodeEntity> findByQrUuid(UUID qrUuid);
    //void deleteByQrUuid(UUID qrUuid);
}
