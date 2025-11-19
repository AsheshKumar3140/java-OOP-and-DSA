Write-Host "Compiling Java files..." -ForegroundColor Green
javac utils/InputUtils.java tut21.java 

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host "Running tut21..." -ForegroundColor Yellow
    java tut21
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
}
