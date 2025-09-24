package com.mykyda.talantsocials.dto.create;

import java.util.UUID;

public record ProfileCreationDTO(UUID userId, String displayName, String tag) {
}
