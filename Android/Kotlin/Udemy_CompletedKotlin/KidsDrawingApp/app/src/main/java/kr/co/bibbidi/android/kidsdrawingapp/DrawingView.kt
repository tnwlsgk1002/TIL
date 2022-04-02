package kr.co.bibbidi.android.kidsdrawingapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionInterpolator

class DrawingView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private var mDrawPath: CustomPath? = null
    private var mCanvasBitmap: Bitmap? = null
    private var mDrawPaint: Paint? = null
    private var mCanvasPaint: Paint? = null
    private var mBrushSize: Float = 0.toFloat()
    private var color = Color.BLACK
    private var canvas: Canvas? = null
    private val mPaths = ArrayList<CustomPath>()
    private val mUndoPahts = ArrayList<CustomPath>()

    init {
        setUpDrawing()
    }

    fun onClickUndo() {
        if(mPaths.size > 0) {
            mUndoPahts.add(mPaths.removeAt(mPaths.size - 1))
            invalidate()
        }
    }

    fun onClickRedo() {
        if(mUndoPahts.size > 0) {
            mPaths.add(mUndoPahts.removeAt(mUndoPahts.size - 1))
            invalidate()
        }
    }

    private fun setUpDrawing() {
        mDrawPaint = Paint()
        mDrawPath = CustomPath(color,mBrushSize)

        mDrawPaint?.color = color
        mDrawPaint?.style = Paint.Style.STROKE
        mDrawPaint?.strokeJoin = Paint.Join.ROUND
        mDrawPaint?.strokeCap = Paint.Cap.ROUND

        mCanvasPaint = Paint(Paint.DITHER_FLAG)
        // mBrushSize = 20.toFloat() -> MainActivity로 이동
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCanvasBitmap = Bitmap.createBitmap(2, h, Bitmap.Config.ARGB_8888)
        canvas = Canvas(mCanvasBitmap!!)
    }

    // 화면을 다시 그릴 필요가 있을 때 호출
    // 오류가 나면 Canvas 를 nullable 로 변경
    // mDrawPaint 설정 및 canvas에 drawPath
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mCanvasBitmap?.let {
            canvas.drawBitmap(it, 0f, 0f, mCanvasPaint)
        }

        for (path in mPaths) {
            mDrawPaint!!.strokeWidth = path.brushThickness // 페인트 두께 설정
            mDrawPaint!!.color = path.color
            canvas.drawPath(path, mDrawPaint!!)
        }
        if (!mDrawPath!!.isEmpty) {
            mDrawPaint!!.strokeWidth = mDrawPath!!.brushThickness // 페인트 두께 설정
            mDrawPaint!!.color = mDrawPaint!!.color
            canvas.drawPath(mDrawPath!!, mDrawPaint!!)
        }
    }

    // 사용자가 터치 이벤트를 일으킬 때 호출
    // mDrawPath or mPaths 설정
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event?.x
        val touchY = event?.y

        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                mDrawPath?.color = color
                mDrawPath?.brushThickness = mBrushSize // Path 의 두께 설정

                mDrawPath?.reset() // 그린 선 지우기
                if (touchX != null) {
                    if (touchY != null) {
                        mDrawPath?.moveTo(touchX, touchY)
                    }
                }
            } // 화면을 처음 눌렀을 때
            MotionEvent.ACTION_MOVE -> {
                if (touchX != null) {
                    if (touchY != null) {
                        mDrawPath?.lineTo(touchX, touchY)
                    }
                }
            } // 누르고 움직일 때-> 그림 그리기
            MotionEvent.ACTION_UP -> {
                mPaths.add(mDrawPath!!)
                mDrawPath = CustomPath(color, mBrushSize)
            } // 누른 걸 뗐을 때
            else -> return false
        }
        invalidate()

        return true
    }
    // 메인에서 접근하므로 public
    fun setSizeForBrush(newSize : Float) {
        // 화면 크기 고려
        // 사용할 단위, 정보값, 측정 기준(->화면 크기)
        mBrushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            newSize, resources.displayMetrics)
        mDrawPaint!!.strokeWidth = mBrushSize
    }

    fun setColor(newColor: String) {
        color = Color.parseColor(newColor)
        mDrawPaint?.color = color
    }
    internal inner class CustomPath(var color: Int, var brushThickness: Float) : Path() // internal - 내부에서만 사용
}