package day07;

public class C99_Sozel {
    /*
        JUnit :
        - Java ile en temel framework JUnit ile olusturulabilir.
        - Developerlar unit testleri calistirmak icin kullanirlar.
        - Biz testlermizi yapmak icin JUnit'in ileri surumu oldugundan TestNG framework olusturup kullanacagiz.
        - mvnrepository.com sitesinden dependency'leri alabilir ve test framework olusturmak
        icin Junit annotationlarini kullanabiliriz.
        - En gelismis ve guncel Framework olarak
        - Java dilinde Annotation, bir veri hakkinda bilgi barindiran veriyi saglayan basit bir yapidir.
        Bu sagladigi bilgiye de "metadata" denir.
        - Annotaion genellikle Java'da konfigurasyon amaciyla kullanilir.
        Kullanildigi bilesene ek ozellikler katar. Bu bilesenler sinif, method, degiskenler, paket ya da
        parametreler olabilir. Bunlarin hepsinde annotation kullanabiliriz.
        - Java dilinde annotation'lar "@" isaretiyle baslar.
        Annaotation'lar ile derleyiciye talimatlar verebiliriz.

        - En cok Kullanilan Junit Annotation'lari
        @Test
        @BeforeClass @AfterClass
        @Before, @After
        @Ignore

        BeforeClass, AfterClass olunca ne oldu ?
        AfterClass butun methodlardan SONRA 1 KEZ CALISTI.
        @Before ve @After'da MER METHOD'dan sonra calisir.
        Her method'da sayfayi kapatip yeniden acmak istiyorsak @Before @After kullanmaliyiz.
        Eger kapatmamiza gerek yoksa @BeforeClass @AfterClass'i kullanmaliyiz.
        @BeforeClass, @AfterClass static olmak zorunda.
        @Ignore : Yazildigi testi yoksayarak calistirmaz ve sonuc ekranina yazdirmaz.

        ASERTIONS (Dogrulama) :
        - JUnite framework'unde test senaryomuzu calistirdiktan sonra bekledigimiz sonuclarin
        olup olmadigini test etmek icin assert sinifinin fonksiyonlarini kullaniriz.
        - JUnit, belirli kosullari test etmek icin isimleri assert ile baslayan statik method'lari saglar.
        - Bu method'larla beklenen ve gercek degerleri karsilastirarak testimizi sonuclandiririz.
        - Bu kiyaslama basarisiz olursa AssertionException ile hata mesaji verilir.
        - Assertion fail olursa icinde bulundugu testin kalan kismini calistirmaz.
            Assert.assertEqual(actualResult,expectedResult)
            Assert.assertTrue(yas>65) => Yasin 65'den buyuk oldugunu test edin. (if-else'den kurtulduk)
            Assert.assertFalse(isim.equals("Ayse")) => Olumsuz cumlegi test icin kullaniriz.(!'den kurtulduk)


     */
}