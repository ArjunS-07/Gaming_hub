package com.gaminghub.gaming_hub.mapper;

import com.gaminghub.gaming_hub.dto.*;
import com.gaminghub.gaming_hub.models.*;

public class DtoMapper {

    // ------------------ AdminUser ------------------
    public static AdminUserResponseDTO toAdminUserResponse(AdminUser adminUser) {
        return new AdminUserResponseDTO(
                adminUser.getId(),
                adminUser.getUsername()
        );
    }

    public static AdminUser toAdminUser(AdminUserRequestDTO dto) {
        return new AdminUser(
                dto.getUsername(),
                dto.getPassword()
        );
    }

    // ------------------ CollectionRecord ------------------
    public static CollectionRecordResponseDTO toCollectionRecordResponse(CollectionRecord record) {
        return new CollectionRecordResponseDTO(
                record.getId(),
                record.getDate(),
                record.getAmount()
        );
    }

    public static CollectionRecord toCollectionRecord(CollectionRecordRequestDTO dto) {
        return new CollectionRecord(
                dto.getDate(),
                dto.getAmount()
        );
    }

    // ------------------ Game ------------------
    public static GameResponseDTO toGameResponse(Game game) {
        return new GameResponseDTO(
                game.getId(),
                game.getName(),
                game.getPrice(),
                game.getDescription()
        );
    }

    public static Game toGame(GameRequestDTO dto) {
        return new Game(
                dto.getName(),
                dto.getPrice(),
                dto.getDescription()
        );
    }

    // ------------------ Member ------------------
    public static MemberResponseDTO toMemberResponse(Member member) {
        return new MemberResponseDTO(
                member.getId(),
                member.getName(),
                member.getPhone(),
                0.0
        );
    }

    public static Member toMember(MemberRequestDTO dto) {
        return new Member(
                dto.getName(),
                dto.getPhone(),
                dto.getBalance()
        );
    }

    // ------------------ Recharge ------------------
    public static RechargeResponseDTO toRechargeResponse(Recharge recharge) {
        return new RechargeResponseDTO(
                recharge.getId(),
                recharge.getMemberId(),
                recharge.getAmount(),
                recharge.getDateTime()
        );
    }

    public static Recharge toRecharge(RechargeRequestDTO dto) {
        return new Recharge(
                dto.getMemberId(),
                dto.getAmount(),
                dto.getDateTime()
        );
    }

    // ------------------ Transaction ------------------
    public static TransactionResponseDTO toTransactionResponse(Transaction transaction) {
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getMemberId(),
                transaction.getGameId(),
                transaction.getAmount(),
                transaction.getDateTime()
        );
    }

    public static Transaction toTransaction(TransactionRequestDTO dto) {
        return new Transaction(
                dto.getMemberId(),
                dto.getGameId(),
                dto.getAmount(),
                dto.getDateTime()
        );
    }
}
