package com.banque.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banque.classe.RendezVous;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

/**
 * Servlet implementation class ExportPdf
 */
@WebServlet("/RecuPdf")
public class RecuPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuPdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String masterPath = request.getServletContext().getRealPath( "/WEB-INF/recu.pdf" );
		RendezVous r = (RendezVous)session.getAttribute("rendezvous");
        response.setContentType( "application/pdf" );
        
        try ( PdfReader reader = new PdfReader( masterPath );
              PdfWriter writer = new PdfWriter( response.getOutputStream() );
              PdfDocument document = new PdfDocument( reader, writer ) ) {
            
            PdfPage page = document.getPage( 1 );
            PdfCanvas canvas = new PdfCanvas( page );
            
            FontProgram fontProgram = FontProgramFactory.createFont();
            PdfFont font = PdfFontFactory.createFont( fontProgram, "utf-8", true );
            canvas.setFontAndSize( font, 22 );
            
            canvas.beginText();
            
            canvas.setTextMatrix( 400, 445 );
            canvas.showText( r.getNom() + " " + r.getPrenom() );
            
            canvas.setTextMatrix( 400, 365 );
            canvas.showText( r.getService() );
            
            canvas.setTextMatrix( 400, 283 );
            canvas.showText( r.getDate() );
            
            canvas.setTextMatrix( 550, 163 );
            canvas.showText( r.getDateReservation() );
            canvas.endText();
        }
        getServletContext().getRequestDispatcher("/vues/rendezVous.jsp").forward(request, response);
	}

}
