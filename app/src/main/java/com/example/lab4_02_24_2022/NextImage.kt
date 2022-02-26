package com.example.lab4_02_24_2022

class NextImage {

    private val allImages: AllImages = AllImages()

    private var img: Int = 0
    private var imgCaption: Int = 0
    private val total_imgs: Int = allImages.allImages.size
    private val total_imgsCaption: Int = allImages.allImageCaptions.size

    public fun linearNextImage(): String {
        img = (img + 1) % total_imgs
        return allImages.allImages[img]
    }

    public fun linearNextImageCapt(): String {
        imgCaption = (imgCaption + 1) % total_imgsCaption
        return allImages.allImageCaptions[imgCaption]
    }
}