package org.example.domain.file.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class File {

    private final UUID fileId;

    private final UUID postId;

    private final UUID testId;

    private final String url;

    private final String filename;
}
