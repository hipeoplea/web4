<template>
  <line class="axis" x1="250" x2="260" y1="0" y2="15"/>
  <line class="axis" x1="250" x2="240" y1="0" y2="15"/>
  <line class="axis" x1="250" x2="250" y1="0" y2="500"/>

  <line class="axis" x1="485" x2="500" y1="240" y2="250"/>
  <line class="axis" x1="485" x2="500" y1="260" y2="250"/>
  <line class="axis" x1="0" x2="500" y1="250" y2="250"/>

  <line class="axis" x1="50" x2="50" y1="240" y2="260"/>
  <line class="axis" x1="100" x2="100" y1="240" y2="260"/>
  <line class="axis" x1="150" x2="150" y1="240" y2="260"/>
  <line class="axis" x1="200" x2="200" y1="240" y2="260"/>
  <line class="axis" x1="300" x2="300" y1="240" y2="260"/>
  <line class="axis" x1="350" x2="350" y1="240" y2="260"/>
  <line class="axis" x1="400" x2="400" y1="240" y2="260"/>
  <line class="axis" x1="450" x2="450" y1="240" y2="260"/>

  <line class="axis" x1="240" x2="260" y1="50" y2="50"/>
  <line class="axis" x1="240" x2="260" y1="100" y2="100"/>
  <line class="axis" x1="240" x2="260" y1="150" y2="150"/>
  <line class="axis" x1="240" x2="260" y1="200" y2="200"/>
  <line class="axis" x1="240" x2="260" y1="300" y2="300"/>
  <line class="axis" x1="240" x2="260" y1="350" y2="350"/>
  <line class="axis" x1="240" x2="260" y1="400" y2="400"/>
  <line class="axis" x1="240" x2="260" y1="450" y2="450"/>

  <text x="485" y="230" font-weight="bold">X</text>
  <text x="270" y="15" font-weight="bold">Y</text>


  <text x="35" y="235">-4</text>
  <text x="85" y="235">-3</text>
  <text x="135" y="235">-2</text>
  <text x="185" y="235">-1</text>
  <text x="295" y="235">1</text>
  <text x="345" y="235">2</text>
  <text x="395" y="235">3</text>
  <text x="445" y="235">4</text>

  <text x="265" y="55">4</text>
  <text x="265" y="105">3</text>
  <text x="265" y="155">2</text>
  <text x="265" y="205">1</text>
  <text x="265" y="305">-1</text>
  <text x="265" y="355">-2</text>
  <text x="265" y="405">-3</text>
  <text x="265" y="455">-4</text>
</template>
<script>
export default {
  name:"staticPicture"
}
</script>

<style scoped>
.axis {
  stroke-width: 2px;
  stroke: #353557;
}
</style>