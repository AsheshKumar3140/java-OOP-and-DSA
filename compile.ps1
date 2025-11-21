Write-Host "Compiling Java files..." -ForegroundColor Green
javac utils/InputUtils.java tut22.java 

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host "Running tut22..." -ForegroundColor Yellow
    java tut22
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
}
