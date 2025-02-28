package org.example.domain.file.model;

import java.util.Optional;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class File {

    private final UUID fileId;

    private final Optional<UUID> postId;

    private final Optional<UUID> testId;

    private final String url;

    private final String filename;
}
