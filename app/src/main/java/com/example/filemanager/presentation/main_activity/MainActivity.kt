package com.example.filemanager.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.filemanager.presentation.navgraph.Navgraph
import com.example.filemanager.ui.theme.FileManagerTheme
import dagger.hilt.android.AndroidEntryPoint
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.File
import java.io.InputStream
import java.io.OutputStream

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FileManagerTheme {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                ) {
                    Navgraph(startDestination = viewModel.startDestination.value,viewModel::onEvent)
                }
            }
        }


    }
//
//    lifecycleScope.launch(Dispatchers.IO) {
//        val docPath = "/sdcard/file-sample_100kB.doc"
//        val outputFile = "${filesDir}/file-sample.pdf"
//
//        val `in`: InputStream = java.io.FileInputStream(File(docPath))
//        val document = XWPFDocument(`in`)
//
//        val options: PdfOptions = PdfOptions.create()
//        val out: OutputStream = java.io.FileOutputStream(outputFile)
//        PdfConverter.getInstance().convert(document, out, options)
//        document.close()
//        out.close()
//    }

    // Method to convert DOCX to PDF
//    fun convertDocxToPdf(File docxFile, File pdfFile) {
//        try (FileInputStream fis = new FileInputStream(docxFile);
//            XWPFDocument docx = new XWPFDocument(fis);
//            PdfWriter writer = new PdfWriter(new FileOutputStream(pdfFile));
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf)) {
//
//                // Iterate through paragraphs in DOCX and add them to the PDF
//                for (XWPFParagraph para : docx.getParagraphs()) {
//                document.add(new Paragraph(para.getText()));
//            }
//
//                System.out.println("DOCX file converted to PDF successfully.");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


//    fun convertDocToPdf(docFile: File, pdfFile: File) {
//        try {
//            FileInputStream(docFile).use { fis ->
//                HWPFDocument(fis).use { doc ->
//                    FileOutputStream(pdfFile).use { fos ->
//                        PdfWriter(fos).use { writer ->
//                            PdfDocument(writer).use { pdf ->
//                                Document(pdf).use { document ->
//                                    val extractor = WordExtractor(doc)
//                                    val paragraphs = extractor.paragraphText
//
//                                    // Add each paragraph to the PDF
//                                    paragraphs.forEach { para ->
//                                        document.add(Paragraph(para))
//                                    }
//
//                                    println(".doc file converted to PDF successfully.")
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
}


