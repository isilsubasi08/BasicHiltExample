# HİLT ÖĞRENELİM 🎉

 Yazılımın temeli olan Solid prensiplerinin son basamağı Dependency Inversion ve onu uygularken neler yapacağımızı öğrenelim.

## Nedir Dependency Inversion ? 
 Üst sınıf alt sınıflara bağımlı olmamalıdır. Yani alt sınıfta yapacağım değişiklik üst sınıfı etkilememelidir. Eğer alt sınıfta bir değişiklik yaparsak ve bu üst sınıfı etkilerse SOLİD prensiplerine uymamış oluruz. 

## Dependency Inversion Uygulama Teknikleri

- Dependecy Injection
- Service Lacotor
- Manuel DI vb.
  
## Dependency Injection 💊
Sınıfı ve nesneyi bağımsızlaştırmamıza yarayan bağımlılıkları kopararak daha test edilebilir ve clean code yazabilmemiz için oluşturulmuş bir tekniktir.

## Dependecy Injection Kütüphaneleri
- Koin
- Dagger
- <b>Hilt</b>
  <br>
Biz basit bir uygulama yapıp Hilt kütüphanesinin tüm temellerini öğreneceğiz.

## HİLT 🌙
Jetpack tarafından önerilen bir dependecy injection(DI) kütüphanesidir.
Dagger kütüphanesinin üzerine kurulmuş ve Dagger'ın tüm avantajlarını basitleştirerek koruyan daha anlaşılabilir yapıda kütüphanedir.<br>
Kullanacağımız annotasyonlarla bu entegre işlemini kolaylıkla yapacağız.

## Hilt’in desteklediği android sınıfları
- Activity
- Fragment
- View
- Service
- BroadcastReceiver
  
## Kullanacağımız Annotasyonlar 

- @HiltAndroidApp
- @AndroidEntryPoint
- @ViewModelInject
- @Inject
- @Module
- @Provide
- @InstallIn

Uygulama yaparken bütün annotasyonların ne işe yaradığından bahsedeceğiz.

## Başlayalım 🌈
## Hilt’i projelerimize nasıl entegre edebiliriz?

 * Project seviyesine build.gradle dosyasına aşağıdaki kodu ekleyelim.<br>
  
   `classpath 'com.google.dagger:hilt-android-gradle-plugin:2.44'`

  * Daha sonra app seviyesindeki build.gradle dosyasına aşağıdaki eklemeleride yapalım.<br> 
	
    `id 'kotlin-kapt'` <br>
    `id 'dagger.hilt.android.plugin'`<br>
     <br> 
       `implementation "com.google.dagger:hilt-android:2.38.1"`<br>
    `kapt "com.google.dagger:hilt-compiler:2.38.1" ` 

Artık Hilt kütüphanesini kullanabiliriz..✨  


## 1-)@HiltAndroidApp -  Application Class

Application classımızda HiltAndroidApp annotasyonunu kullanarak ilk adımımızı tamamlıyoruz. Bu diğer işlemler için gerekli olan en önemli noktadır.Hilt'in kod oluşturmasını tetiklemek için.

 @HiltAndroidApp<br>
class MyHiltApp : Application() {<br>
    <br>
 }<br>

 Daha sonra manifest dosyasına aşağıdaki gibi oluşturduğumuz classı tanımlamalıyız.<br>
 `android:name=".MyHiltApp"`

 ## 2-) @AndroidEntryPoint
 Hilt , android bileşenine container sağlayarak yaşam döngülerini sizin için otomatik olarak yönetir ve böylece uygulamanızda DI yapmanın standart bir yolunu tanımlar.

- @AndroidEntryPoint annotation'ı ile activityde Hilt'i etkinleştiriyoruz.<br>
- Hilte bağımlılıklarımızı nereye etkinleştirmek istediğimizi belirtiyoruz. <br>
- Android giriş noktası olan bir aktiviteye annotasyon  eklerseniz ve bu aktivite bağımlılıklar içeriyorsa, o aktiviteyi kullanan aktivite veya aktivitelere de açıklama eklemelisiniz.<br>

 

     
      @AndroidEntryPoint
      class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
            }
        }  


## 3-) @Inject constructor() - Constructor injection 

- Bağımlılık oluşturmanın en temel yolu constructor injectiondır.
- Her yere hazır hale getirmeyi sağlayan inject annotasyonudur.

Örneğimizde 2 tane class oluşturacağız.<br>
DatabaseAdapter sınıfımıza DatabaseService sınıfını sağlamak için @Inject annotasyonunu kullanarak Hilte bildireceğiz.


*DatabaseService Class<br>

        class DatabaseService @Inject constructor() {
            fun log(msg : String){
            Log.d(TAG,"DatabaseService : $msg" )
            }
      }



*DatabaseAdapter Class<br>
        
         class DatabaseAdapter @Inject constructor(var      databaseService: DatabaseService){

            fun log(msg : String){
                Log.d(TAG,"DatabaseAdapter : $msg")
                databaseService.log(msg)
          }
    }
  

## 4-) @Inject -Field Injection

- DatabaseAdapter classını kullanmak için ise field injectiona ihtiyacım var.
- Bunu inject etmem gerekiyor.

- DatabaseAdapter classımı MainActiviy classıma enjekte etmek istiyorum.

        @Inject lateinit var databaseAdapter: DatabaseAdapter



Son hali : 

            @AndroidEntryPoint
            class MainActivity : AppCompatActivity() {

             @Inject 
             lateinit var databaseAdapter:DatabaseAdapter

             override fun onCreate(savedInstanceState:  Bundle?) {
                 super.onCreate(savedInstanceState)
                 setContentView(R.layout.activity_main)

             Log.d(TAG,"DatabaseAdapter : $databaseAdapter")
             databaseAdapter.log("Hey Hilt")

        }
    }


Bir sonraki anlatımda MVVM mimarisi ve Retrofit kütüphanesi kullandığımız uygulamada Hilt entegre edeceğiz.Diğer kullanmadığımız tanımlarıda diğer projede göreceğiz.


 





         

















  
  






