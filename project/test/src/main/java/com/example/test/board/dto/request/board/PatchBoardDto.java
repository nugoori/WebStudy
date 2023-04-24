package com.example.test.board.dto.request.board;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchBoardDto {
    
    @Min(1)
    private int boardNumber;

    @NotBlank
    private String boardContent;

    private String boardImgUrl1;

    private String boardImgUrl2;

    private String boardImgUrl3;
}
