# Carousel-Slider
Carousel is a component to show the users a slideshow, usually images using ViewPager2.

## Implementation

1) Add following lines, in viewPager's parentView

       android:clipChildren="false"
       android:clipToPadding="false"

2) Add some horizontal margin/padding in viewPager for preview. `e.g. 40dp`

3) Add carousel effect using following line. By default, zoom effect is enabled. However, we can disable it by passing `false` as a parameter

        binding.viewPager.addCarouselEffect(enableZoom = false)
        
4) Add an `extension-function` in `object` type class:

       fun ViewPager2.addCarouselEffect(enableZoom: Boolean = true) {
            clipChildren = false    // No clipping the left and right items
            clipToPadding = false   // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect

            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer((20 * Resources.getSystem().displayMetrics.density).toInt()))
            if (enableZoom) {
                compositePageTransformer.addTransformer { page, position ->
                    val r = 1 - abs(position)
                    page.scaleY = (0.80f + r * 0.20f)
                }
            }
            setPageTransformer(compositePageTransformer)
        }


## Zoom Effect

https://github.com/epegasus/Carousel-Slider/assets/100923337/28170f0c-a99d-4c8b-87d7-7cf0d46282d5

## Without Zoom Effect

https://github.com/epegasus/Carousel-Slider/assets/100923337/1173cebd-9537-4f9d-9bcf-3b06c0c7d653
