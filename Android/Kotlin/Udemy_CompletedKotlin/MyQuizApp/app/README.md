# Quiz 앱 만들기

## 첫 화면 : 이름 입력
- `ActionBar` 없애기
  - `manifests/AndroidManifest.xml` : `Activity` 만들고 설정(ex.어떤 `Activity`로 시작)
  - `AndroidManifest.xml`에서 `android:theme="@style/Theme.MaterialComponents.DayNight.NoActionBar"`로 설정
  - 혹은 `android:theme="@style/Theme.MyQuizApp"`으로 두고 `theme.xml`에서 `<style name="Theme.MyQuizApp" parent="Theme.MaterialComponents.DayNight.DarkActionBar">` 로 설정도 가능
- 세로 모드 설정
  - `AnroidManifest.xml`에서 `Activity` 속성에 `android:screenOrientation="portrait"` 추가
- `LinearLayout` 설정
  - `LinearLayout`이 두 개 이상이라면 둘 다 `orientation`을 해주어야 함
- `CardView`
  - `TextInput` 설정
    - `AppCompatEditText`으로 입력값 설정하기 : `hint`, `inputType`
  - `cardCornerRadius` : 둥근 모서리
- 상태바 없애기
  - `themes.xml`에 `<item name="android:windowFullscreen">true</item>` 추가