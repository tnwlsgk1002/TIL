# Kids Drawing App

## 키즈 드로잉 앱 세팅하기 - 드로잉 뷰
- 항상 세로 모드 설정 : `AndroidManifest.xml`에 `android:screenOrientation="portrait"` 추가
- `DrawingView` 클래스
    - `View` 클래스 상속
    - `Path`를 상속받는 `CustomPath` 
      `Path`는 사용자가 그림을 그리는대로 따라옴.
    - `Bitmap`
    - `Paint`
    - `Canvas`
    - `MotionEvent` 클래스
      - `ACTION_DOWN` : 처음 눌렀을 때
      - `ACTION_MOVE` : 누르고 움직였을 때
      - `ACTION_UP` : 누른 걸 뗐을 때
    - `invalidate()` : 뷰가 화면에 보일 때 전체 뷰를 무효화, 그리고 onDraw 실행
    - `OnDraw()` : 화면을 다시 그릴 필요가 있을 때 호출
    
## 화면에 선 계속 보이게 하기
- `mPaths = ArrayList<CustomPath>()` 추가
- 그릴 때마다`path`를 추가하고 `onDraw()` 시 설정

## 캔버스 주변에 작은 보더 추가하기
- `activity_main.xml` 상에서 `view`의 background 추가
- 이 때 constraint layout을 사용하므로 xml에 간격 추가
- 생성된 backgroud xml에서 stroke 설정

## BrushSizeSelector 준비하는 법과 DisplayMetrics를 사용하는 법
- BrushSize 조절
    - `fun setSizeForBrush` 선언
        - 화면 크기 고려 : `TypedValue.applyDimension(uint: Int, value: Float, metrics: DisplayMetrics!)` 사용
        - unit : 사용할 단위, value : 정보값, metrics : 측정 기준
    - `MainActivity.kt`에서 호출 가능
    
## 생성한 커스텀 다이얼로그에서 브러쉬 사이즈 선택하기
- `layout/`에 `dialog_brush_size.xml` 생성
    - `drawable/small.xml` 생성
        - `dither` 속성을 통해 비트맵이 화면과 동일한 픽셀 구성을 가지고 있지 않은 경우 비트맵 디더링을 사용하거나 사용하지 않을 수 있다.
            ex) 여기서는 RGB 구성 사용 -> 실제 사용자 화면은 ARGB 구성 사용할 때 다른 화면에서도 작동하도록 이미지 자동 조정
- `acitivity_main.xml`에 `ImageButton` 추가
    - `ImageButton` 속성 중 `scaleType`을 `fitXY`로 설정하면 드래그할 때 화면 크기에 맞춰진다.
    
## 생성한 커스텀 드러어블을 사용하여 색상 팔레트 추가하기
- `pallet_normal.xml`추가
   - `layer-list` 사용 : `item` 속성을 여러 번 사용하면 겹쳐지는 것을 볼 수 있음
- `pallet_pressed.xml` 추가 : 선택한 색상 강조
- 각각의 생성한 `imageButton` 에 `tag` 속성 추가 : 선택한 버튼이 무엇인지 확인하고 색상을 사용할 수 있도록 만듦. : `stoke`의 색상 바꿈
    - `Linearlayout`에 id를 추가하고 안의 `imageButton`은 `index`로 찾기
        : `linearLayoutPaintColors[1] as ImageButton`
- pallet_normal.xml -> pallet_pressed.xml 로 변경(재정의)
  ```kotlin
      mImageButtonCurrentPaint!!.setImageDrawable(
        ContextCompat.getDrawable(this, R.drawable.pallet_pressed) // 이미지 버튼의 view를 pallet_pressed로 설정
    )
  ```
  
## 색상 선택 추가하기
- `String` 으로 `color` 를 읽어서 `Color.parseColor`로 적용
- cf) [그 외 방법으로 색상 선택하는 방법](https://www.geeksforgeeks.org/how-to-create-a-color-picker-tool-in-android-using-color-wheel-and-slider/)

## 백그라운드 이미지 추가하기
- `frameLayout` : 여러 개의 뷰가 겹쳐질 수 있음

## UI에 갤러리 이미지버튼 추가하기
- LinearLayout 추가하여 기존 브러쉬 버튼과 함께 추가

## 권한 데모
- PermissionsDemo 프로젝트 생성
- `AndroidManifest.xml`에서 `<uses-permission android:name="android.permission.CAMERA"/>` 추가
  이 외에도 위치와 같은 권한을 해당 xml에서 요청 가능
  

## 스낵바 - AlertDialog - 커스텀 다이얼로그 데모 파트
- [스낵바와 토스트의 차이](https://stackoverflow.com/questions/34432339/android-snackbar-vs-toast-usage-and-difference)
### Alert Dialog
### 
  

## 커스텀 실행 바 다이얼로그
## 키즈드로잉 앱에 앱 권한 요청 추가하기
## 갤러리에서 이미지 선택하여 백그라운드에 사용하기
## 취소 버튼과 기능 추가하기
## 코루틴을 사용하여 백그라운드에서 무언가 해보기
## 공급자 추가하기 - 앱에 패스와 이미지 샌드위치 메이커 추가하기
## 휴대폰에 있는 이미지를 코루틴과 출력스트림을 사용하여 저장하기
## 커스텀 실행 다이얼로그 반영하고 완료 후 숨기기
## 이메일, 왓츠앱 등으로 이미지를 공유하는 공유 긴능 추가하기
