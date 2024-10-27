package com.example.filemanager.domain.model


data class FileItem(
    var name: String,
    var path: String,
    var type: String,
    var size: String,
    var lastModifiedTime: String,
    var lastModifiedTimeLong: Long
)